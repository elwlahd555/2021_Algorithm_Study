T=int(input())
for tc in range(1,T+1):
    N=int(input())
    result=[[0 for i in range(N*2)] for j in range(N*2)]
    for i in range(N):
        temp=list(map(int,input().split()))
        for j in range(N):
            result[i][j]=temp[j]
            result[2*N-1-j][2*N-1-i]=temp[j]
            result[i][2*N-1-j]=temp[j]
            result[2*N-1-i][j]=temp[j]
    
    print(result)