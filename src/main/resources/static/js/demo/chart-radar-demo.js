// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// radar Chart Example
var ctx = document.getElementById("myRadarChart");
var options = {
    scale: {
        angleLines: {
            display: false
        },
        ticks: {
            suggestedMin: 50,
            suggestedMax: 100
        }
    }
};
var myRadarChart = new Chart(ctx, {
  type: 'radar',
  data: {
    labels: ['Running', 'Swimming', 'Eating', 'Cycling', 'asdfasdf', 'fwfwfwf'],
    datasets: [{
        data: [100, 80, 60, 40, 20, 10,]
    }]
}, option : options
});
