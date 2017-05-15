<html>
    <head>
        <link href="/demo/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"/>
        <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"/>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
        <script src="/demo/js/script.js" type="text/javascript"></script>
    </head>
    <body class="cheesy-background">
        <div class="wrapper flex flex-column flex-center pad-10">
            <div class="header-wrapper">
                <p>Welcome, ${username}</p>
                <form name='logout-form' action="logout" method='POST'>
                    <input class="box button text-center" name="submit" type="submit" value="Logout"/>
                </form>
            </div>
            <div class="element-wrapper">
                <h1 class="title text-center mb-20 fb-auto">Cheesy</h1>
            </div>
            <div class="element-wrapper">
                <form id="cheese-form" class="form">
                    <div id="name-wrapper" class="flex flex-column fg-2">
                        <input id="name" class="box border text-center text-input text-large bold fg-2" type="text" name="name" placeholder="Enter Cheese..."
                               autocomplete="off"/>
                    </div>
                    <div id="taste-wrapper" class="flex flex-column">
                        <select id="taste" name="taste" class="border box text-large text-center fg-1">
                            <option value="" disabled selected>Taste..</option>
                            <option value="Horrible">Horrible</option>
                            <option value="So-So">So-So</option>
                            <option value="Good">Good</option>
                            <option value="Delicious">Delicious</option>
                        </select>
                    </div>
                    <input id="add-button" class="box button text-center" name="submit" type="submit" value="Add" />
                </form>
            </div>
            <div class="element-wrapper">
                <div class="table-wrapper">
                    <table id="cheese-table" class="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Cheese</th>
                            <th>Taste</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
