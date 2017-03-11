#!/bin/sh

echo "Checking for Homebrew..."
command -v brew >/dev/null && echo "Homebrew installed." || {
    echo "Homebrew not installed.";
    echo "Installing Homebrew...";
    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
}

brew update

brew install caskroom/cask/brew-cask

brew cask install docker-toolbox

docker-machine create --driver "virtualbox" default

docker-machine start default

eval "$(docker-machine env default)"

docker run -it ubuntu