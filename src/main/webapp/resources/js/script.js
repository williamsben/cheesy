$(document).ready(function() {

    var table = $('#cheese-table').DataTable({
      "ajax": "/demo/cheeses",
      "columns": [
        { "data": "id" },
        { "data": "name" },
        { "data": "taste" }
      ],
      "paging": false,
      "searching": false,
      "info": false,
      "autoWidth": false
    });

    $('#add-button').click(function(e){
        e.preventDefault();
        $.post("/demo/", $("#cheese-form").serialize(), function(data){
            table.ajax.reload();
        });
    });

} );
