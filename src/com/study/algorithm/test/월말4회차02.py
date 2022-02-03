def dfs(cnt):
    if(cnt==N):
        global answer01
        temp_answer=0
        for i in range(N):
            temp_answer+=answer_arr[i]
        if temp_answer<answer01:
            answer01=temp_answer
        return
    for i in range(N):
        if visit[i]==1:
            continue
        answer_arr[cnt]=arr[cnt][i]
        visit[i]=1
        dfs(cnt+1)
        visit[i]=0



T=int(input())
N=0
arr=[]
answer_arr=[]
visit=[]
answer01=1000000000000
for tc in range(1,T+1):
    N=int(input())
    visit=[0 for i in range(N)]
    answer_arr=[0 for i in range(N)]
    arr=[]
    for i in range(N):
        arr.append(list(map(int,input().split())))
    dfs(0)
    print(answer01)