A,B=map(int, input().split())
ans=-1
que=[A]
time=0
while len(que)>0:
    size=len(que)
    for i in range(size):
        num=que.pop(0)
        if num==B:
            ans=time+1
            break
        if num*2<=B:
            que.append(num*2)
        if int(str(num)+'1')<=B:
            que.append(int(str(num)+'1'))
    time+=1
print(ans)
