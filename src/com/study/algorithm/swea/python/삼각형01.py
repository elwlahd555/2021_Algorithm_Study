T=int(input())
for tc in range(1, T+1):
    n,m = map(int, input().split())
    print(f"#{tc}")
    if m==1:
        a=1
        for i in range(0, n//2):
            answer=""
            for j in range(a):
                answer+="*"
            print(answer)
            a+=1
        for i in range(n//2, n):
            answer=""
            for j in range(a):
                answer+="*"
            print(answer)
            a-=1
    elif m==2:
        a=2
        for i in range(n):
            answer=""
            for j in range(a):
                answer+=" "
            for j in range(a,n//2+1):
                answer+="*"
            if i>=n//2:
                a+=1
            else:
                a-=1
            print(answer)
    elif m==3:
        a=0
        for i in range(n):
            answer=""
            for j in range(a):
                answer+=" "
            for j in range(n-2*a):
                answer+="*"
            for j in range(a):
                answer+=" "
            if i>=2:
                a-=1
            else:
                a+=1
            print(answer)    
    else:
        for i in range(n):
            answer=""
            if i>=n//2:
                for j in range(n//2):
                    answer+=" "
                for j in range(i-n//2+1):
                    answer+="*"
            else:
                for j in range(i):
                    answer+=" "
                for j in range(n//2-i+1):
                    answer+="*"
            print(answer)
    