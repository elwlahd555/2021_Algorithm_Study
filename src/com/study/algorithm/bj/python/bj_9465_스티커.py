T=int(input())
for tc in range(1,T+1):
    N=int(input())
    arr=[]
    for _ in range(2):
        arr.append(list(map(int,input().split())))
    
    arr[0][1]+=arr[1][0]
    arr[1][1]+=arr[0][0]
    for i in range(2,N):
        arr[0][i]+=max(arr[1][i-1],arr[1][i-2])
        arr[1][i]+=max(arr[0][i-1],arr[0][i-2])
    print(max(arr[0][N-1],arr[1][N-1]))


