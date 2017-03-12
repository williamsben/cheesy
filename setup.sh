#!/bin/sh

function checkIfInstalled {
    echo "Checking for $1..."
    command -v $2 >/dev/null && echo "$1 installed." || {
        echo "$1 not installed.";
        echo "Installing $1...";
        eval $3
    }
}

checkIfInstalled "Homebrew" brew '/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"'

brew update

brew install caskroom/cask/brew-cask

brew cask install docker-toolbox

docker-machine create --driver "virtualbox" default

docker-machine start default

eval "$(docker-machine env default)"

docker run -it --name war_builder benwilliams/git-maven https://github.com/williamsben/cheesy.git

mkdir cheesy

cd cheesy

path=`pwd`

docker cp war_builder:/cheesy/. $path

docker rm war_builder

db_id=`docker run --rm -e MYSQL_RANDOM_ROOT_PASSWORD=yes -v $path/db_start_up.sql:/docker-entrypoint-initdb.d/db_start_up.sql -d mysql/mysql-server`

db_ip=`docker inspect --format '{{ .NetworkSettings.Networks.bridge.IPAddress }}' $db_id`

echo "Initializing MySQL container..."

check=`docker logs $db_id 2>/dev/null | grep "MySQL init process done. Ready for start up."`
while [[ -z $check ]]; do
  check=`docker logs $db_id 2>/dev/null | grep "MySQL init process done. Ready for start up."`
done

echo "MySQL init process complete. Listening at $db_ip on port 3306."

port=$1
if [ -z $1 ]
then
  port=8080
else
  port=$1
fi

path=`pwd`

echo "Initializing tomcat container to listen at localhost:$port."

VBoxManage controlvm default natpf1 "tomcat,tcp,127.0.0.1,8080,,8080"

docker run --rm -it -p $port:8080 -v $path/target/demo-0.0.1-SNAPSHOT.war:/usr/local/tomcat/webapps/demo.war -v $path/context.xml:/usr/local/tomcat/conf/context.xml -e CATALINA_OPTS=-Ddb_ip=$db_ip --link $db_id tomcat

cd ..

rm -rf cheesy

docker rm -f $db_id

VBoxManage controlvm default natpf1 delete "tomcat"


