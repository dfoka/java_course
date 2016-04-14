package ru.stqa.pft.sandbox;

class Point {

  double x;
  double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  double distance(Point a) {
    return Math.sqrt(((x - a.x) * (x - a.x)) + ((y - a.y) * (y - a.y)));
  }
}


