% https://docs.octave.org/v4.0.3/Simple-File-I_002fO.html        helped understand how dlm helps read files
% https://fossies.org/linux/octave/scripts/statistics/movmean.m  helped implement smoothing for the y values
% https://www.mathworks.com/help/matlab/ref/movmean.html         supplementary source for function
function smootherO(windowsize, inputcsv, outputcsv)
  pairs = dlmread(inputcsv, ',');                 % read x and y pairs from the csv
  x = pairs(:, 1);                                % assign x to first column in csv
  y = pairs(:, 2);                                % assign y to second column in csv
  if windowsize > length(y)
    error('windowsize has to be within the size of xy pairs and greater than 0');
  end
  smoothy = movmean(y, windowsize);
  figure;                                         % Opens Octave graph tab
  plot(x, smoothy, 'b-', 'LineWidth', 3);         % plots the xy pairs
  grid on;                                        % turn gridlines on
  title(outputcsv);                               % graph title
  set(gca, 'fontsize', 18);                       % graph fontsize set to 18
  xlabel('X');                                    % graph x axis label
  ylabel('Y');                                    % graph y axis label
  filesaver(x, smoothy, outputcsv);               % utilizes filesaver function to write xy pairs to csv file
end
