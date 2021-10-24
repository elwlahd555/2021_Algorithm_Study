T=int(input())
for tc in range(1,T+1):
    N=int(input())
    arr=[]
    for i in range(N):
        arr.append(list(map(int,input().split())))
    size=0
    answer=0
    for i in range(N):
        for j in range(N):
            if arr[0][i]==arr[N-1][j]:
                if size<abs(i-j):
                    size=abs(i-j)
                    answer=1
                elif size==abs(i-j):
                    answer+=1

    for i in range(N):
        for j in range(N):
            if arr[i][0]==arr[j][N-1]:
                if size<abs(i-j):
                    size=abs(i-j)
                    answer=1
                elif size==abs(i-j):
                    answer+=1
    print(answer)