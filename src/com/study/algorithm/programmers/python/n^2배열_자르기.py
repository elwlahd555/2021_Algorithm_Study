def solution(n, left, right):
    answer = []
    x1=left//n
    y1=left%n
    x2=right//n
    y2=right%n
    if x1==x2:
        for i in range(y1,y2+1):
            answer.append(max(x1,i)+1)
    else:
        for i in range(y1,n):
            answer.append(max(x1,i)+1)
        for i in range(x1+1,x2):
            for j in range(n):
                answer.append(max(i,j)+1)
        for i in range(y2+1):
            answer.append(max(x2,i)+1)
    return answer


print(solution(3,2,5))