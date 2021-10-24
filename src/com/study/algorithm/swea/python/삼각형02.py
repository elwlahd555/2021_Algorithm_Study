T=int(input())
for tc in range(1, T+1):
    N,M=map(int,input().split())
    print(f"#{tc}")
    if M==1:
        for i in range(1,N+1):
            answer=""
            for j in range(i):
                answer+="*"
            print(answer)
    elif M==2:
        for i in range(N):
            answer=""
            for j in range(N-i):
                answer+="*"
            print(answer)
    else:
        a=1
        for i in range(1,N+1):
            answer=""
            for j in range(N-i):
                answer+=" "
            for j in range(a):
                answer+="*"
            for j in range(N-i):
                answer+=" "
            a+=2
            print(answer)
