% https://docs.octave.org/v4.0.0/Multiple-Return-Values.html    helped understand  multi-element vectors and how utilize them for the x bounds
function grapherO(bounds, inc, outputcsv)    % function to graph equation and save to csv
 lower = bounds(1);                          % sets bounds first scalar value to lower
 upper = bounds(2);                          % sets bounds second scalar value to upper
 if lower >= upper                           % if lower is greater than/equal to upper
    error("bounds has to have lower value be less than the upper value");   % display error message and end
 end
 if inc >= (upper - lower) || inc <= 0                                      % if inc isn't within bound differnce or less than 0
    error("inc has to be less than bounds's differnce and greater than 0"); % display error message and end
 end
 x = lower:inc:upper;                        % set x to within bounds and incremented by inc
 y = 3 * x.^2 + 5 * x + 3;                   % set y to equation 3x^2 + 5x + 3
 figure;                                     % Opens Octave graph tab
 plot(x, y, 'b-', 'LineWidth', 3);           % plots the equation
 grid on;                                    % turn gridlines on
 title(outputcsv);                           % graph title
 set(gca, 'fontsize', 18);                   % graph fontsize set to 18
 xlabel('X');                                % graph x axis label
 ylabel('Y');                                % graph y axis label
 filesaver(x,y,outputcsv);                   % utilizes filesaver function to write xy pairs to csv file
end


