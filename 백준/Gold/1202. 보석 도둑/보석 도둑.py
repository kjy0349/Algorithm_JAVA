import heapq
import sys

N, K = map(int, sys.stdin.readline().split())
jewerly = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
bags = [int(sys.stdin.readline()) for _ in range(K)]
jewerly.sort()
bags.sort()

result = 0
temp = []

for bag in bags:
    while jewerly and bag >= jewerly[0][0]: # jewerly에 element가 존재하고, 가방 하나의 무게가 해당 보석의 무게보다 크거나 같으면
        heapq.heappush(temp, -jewerly[0][1]) # temp list에 보석의 가격을 넣어준다. 최대힙 방식을 사용하기위해 음수로 넣어줌
        heapq.heappop(jewerly) # 해당 보석(jewerly[0])을 가방에 넣었으므로, jewerly의 첫번째 요소를 뽑아준다.
    if temp:
        result += heapq.heappop(temp)
    elif not jewerly:
        break
print(-result)

