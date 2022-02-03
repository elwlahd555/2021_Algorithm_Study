import itertools

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

    print()
    print(answer01)