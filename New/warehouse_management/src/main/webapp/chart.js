document.addEventListener('DOMContentLoaded', function () {
    var ctx = document.getElementById('itemsChart').getContext('2d');

    // Data fetched from the server
    var labels = [];
    var data = [];

    // Fetch data from JSP variables
    var items = ${items};  // This should be a list of item objects

    items.forEach(function(item) {
        labels.push(item.name);
        data.push(item.quantity);
    });

    var itemsChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Quantity',
                data: data,
                backgroundColor: '#3f51b5',
                borderColor: '#303f9f',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                x: {
                    beginAtZero: true
                },
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});
