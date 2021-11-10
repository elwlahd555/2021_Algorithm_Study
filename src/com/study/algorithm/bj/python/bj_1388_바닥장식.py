N,M=map(int,input().split())
arr=[]
check_r=0
check_c=0
answer=0
visit=[[0 for i in range(N)]for j in range(M)]
for i in range(N):
    arr.append(list(i for i in input()))
for i in range(N):
    for j in range(M):
        if arr[i][j]=='-':
            check_r+=1
        elif arr[i][j]!='-'and check_r>0:
            answer+=1
            check_r=0
    if check_r>0:
        answer+=1
        check_r=0

for i in range(M):
    for j in range(N):
        if arr[j][i]=='|':
            check_c+=1
        elif arr[j][i]=='-' and check_c>0:
            answer+=1
            check_c=0
    if check_c>0:
        answer+=1
        check_c=0


print(answer)

