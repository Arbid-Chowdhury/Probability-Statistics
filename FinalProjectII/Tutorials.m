% Tutorial 1 Scatterplot Graph
x = [1,2,3,4];
y = [4,3,2,1];
plot(x,y,'or', 'MarkerSize', 15);
grid on;
title('Tutorial XY Graph');
set(gca, 'fontsize', 22);
xlabel('X Values');
ylabel('Y Values');

% Tutorial 1 Line Graph
figure;
xline = linspace(-4,4,6);
yline = 1.5*xline + 4;
plot(xline,yline, 'bo-');
grid on;
title('Tutorial XY Linear Graph');
xlabel('X Values');
ylabel('Y Values');
set(gca, 'fontsize', 20);

% Tutorial 2 Functions
function AreaOf = fn_recArea(x,y)
  AreaOf = x*y;
end
newarea = fn_recArea(10,10);

function [A,V] = fn_calcAV(r)
  A = 4*pi*r^2;
  V = 4/3*pi*r^3;
end
[Area,Vol] = fn_calcAV(5)


