import itertools

N,M=map(int,input().split())
arr = list(itertools.combinations([i for i in range(1,N+1)],M))

for i in arr:
    answer=""
    for j in i:
        answer+=str(j)
        answer+=" "
    print(answer)