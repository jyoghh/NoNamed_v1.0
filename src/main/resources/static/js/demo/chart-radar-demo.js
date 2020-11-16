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
            suggestedMin: 0,
            suggestedMax: 100
        }
    }
};
var myRadarChart = new Chart(ctx, {
  type: 'radar',
  data: {
    labels: ['OS', 'DBMS', 'WEB', 'Network', '보안장비', '관리보안', '개인정보'],
    datasets: [{
        data: [100, 80, 40, 70, 80, 100, 65]
    }]
}, option : options
});
