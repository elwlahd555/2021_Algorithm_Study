class Point:
    def __init__(self, x,y):
        self.x=x
        self.y=y


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = []
    que=list()
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    answer=0
    visited=[[0 for _ in range(N)] for _ in range(N)]
    for i in range(N):
        arr.append(list(map(int, input().split())))
        if len(que)==0:
            for j in range(N):
                if arr[i][j]==2:
                    que.append(Point(i,j))
                    visited[i][j]=1

    while len(que)>0:
        p=que.pop(0)
        if arr[p.x][p.y]==3:
            answer=1
            break
        for k in range(4):
            x=p.x+dx[k]
            y=p.y+dy[k]
            if x>=0 and x<N and y>=0 and y<N and (arr[x][y]==0 or arr[x][y]==3) and visited[x][y]==0:
                que.append(Point(x,y))
                visited[x][y]=1
    
    print(f"#{tc} {answer}")
    

