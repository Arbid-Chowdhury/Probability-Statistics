% https://docs.octave.org/v4.0.3/Simple-File-I_002fO.html      helped understand how dlm helps write xy values as columns for csv file to be altered with salterO/smootherO
% https://www.youtube.com/watch?v=cLo2UOBU5yY                  supplermentary source and helped understand reading csvs and how to deal with its data
% https://www.sharetechnote.com/html/Octave_Matlab_csv.html    supplementary source for function
function filesaver(x, y, filename)                               % function to save xy pairs to file
  pairs = [x(:), y(:)];                                          % pairs set to xy in column format for csv
  writer = fopen(filename, 'w');                                 % file writer opened to add header
  fprintf(writer, 'x , y\n');                                    % display two line header
  fprintf(writer, '---------------\n');
  fclose(writer);                                                % file writer closed
  dlmwrite(filename, pairs,'delimiter', ',');                    % writes the pairs to the file
  fprintf("the graphed xy pairs are written in %s\n", filename); % displays csv message
end
