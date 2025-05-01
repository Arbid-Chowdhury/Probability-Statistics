% Graphing csv
grapherO( [-30,30], 1, 'graphedData.csv');
grapherO( [-60,60], 1, 'graphedData2.csv');
grapherO( [-80,80], 1, 'graphedData3.csv');

% Salting  csvs
salterO( [-55, 55], 'graphedData.csv', 'saltedData.csv');
salterO( [-95, 95], 'graphedData2.csv', 'saltedData2.csv');
salterO( [-195, 195], 'graphedData3.csv', 'saltedData3.csv');

% Smoothing csvs
smootherO(5, 'saltedData.csv', 'smoothedData.csv');
smootherO(10, 'saltedData2.csv', 'smoothedData2.csv');
smootherO(15, 'saltedData3.csv', 'smoothedData3.csv');







