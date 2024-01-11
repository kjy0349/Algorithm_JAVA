import sys; r = sys.stdin.readline
N = int(r().rstrip())
distances = list(map(int, r().rstrip().split()))
stations = list(map(int, r().rstrip().split()))
cheap_station = stations[0]
result = 0
for i in range(len(distances)):
    if stations[i] > cheap_station:
        result += cheap_station * distances[i]
    else:
        result += stations[i] * distances[i]
        cheap_station = stations[i]
print(result)