# 1232 사칙연산
def operation(n):
    if ni[n][1] == '-':
        return operation((int(ni[n][2])-1))-operation(int(ni[n][3])-1)
    if ni[n][1] == '+':
        return operation((int(ni[n][2])-1))+operation(int(ni[n][3])-1)
    if ni[n][1] == '*':
        return operation((int(ni[n][2])-1))*operation(int(ni[n][3])-1)
    if ni[n][1] == '/':
        return operation((int(ni[n][2])-1))/operation(int(ni[n][3])-1)
    else:
        return int(ni[n][1])
 
 
# [ 입력 ]
# 테스트케이스는 총 10개이다.
T = 10
for tc in range(1,T+1):
    # 첫 줄에는 정점의 총수가 나온다.
    N = int(input())
    # 각각의 정점의 정보가 주어진다.(node information)
    ni = [list(map(str,input().split())) for _ in range(N)]
    result = int(operation(0))
    print('#{} {}'.format(tc,result))