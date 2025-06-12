import math

def rotate_point(x, y, theta) -> tuple: #Function definition with explicit type returning
    """Rotates (x, y) by theta radians"""
    new_x = x*math.cos(theta) + y*math.sin(theta)
    new_y = y*math.cos(theta) + x*math.sin(theta)
    return (new_x, new_y)

def rad_to_deg(theta: float):
    """Converts radians to degrees"""
    theta /= math.pi
    theta *= 180
    return theta

def deg_to_rad(theta: float):
    """Converts degrees to radians"""
    theta /=180
    theta *= math.pi
    return theta

print(deg_to_rad(90))
print(math.pi/2)
print(rotate_point(1, 0, deg_to_rad(90)))