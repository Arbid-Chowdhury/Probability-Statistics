% https://docs.octave.org/v4.0.3/Simple-File-I_002fO.html      helped understand how dlm helps read files
% https://www.mathworks.com/help/matlab/ref/rand.html          helped implement the salting logic
% https://www.youtube.com/watch?v=cLo2UOBU5yY                  helped understand reading csvs and how to deal with its data
function salterO(saltbound, inputcsv, outputcsv)  % function to salt y values and save to new salted csv
  pairs = dlmread(inputcsv, ',');                 % read x and y pairs from the csv
  x = pairs(:, 1);                                % assign x to first column in csv
  y = pairs(:, 2);                                % assign y to second column in csv
  saltlower = saltbound(1);                       % lower scalar of saltbound is set
  saltupper = saltbound(2);                       % upper scalar of saltbound is set

  if saltlower >= saltupper                                                     % if saltlower is greater than/equal to saltupper
    error("saltbound has to have its lower bound lower than it's upper bound"); % display error message and end
  end
  diff = saltupper - saltlower;                   % set salt diff for salt values
  salting = rand(size(y)) * diff + saltlower;     % creates salting values shifted within the saltbound
  salty = y + salting;                            % sets saltedy to original y with saltig added
  figure;                                         % Opens Octave graph tab
  plot(x, salty, 'b-', 'LineWidth', 3);           % plots the xy pairs
  grid on;                                        % turn gridlines on
  title(outputcsv);                               % graph title
  set(gca, 'fontsize', 18);                       % graph fontsize set to 18
  xlabel('X');                                    % graph x axis label
  ylabel('Y');                                    % graph y axis label
  filesaver(x, salty, outputcsv);                 % utilizes filesaver function to write xy pairs to csv file
end


