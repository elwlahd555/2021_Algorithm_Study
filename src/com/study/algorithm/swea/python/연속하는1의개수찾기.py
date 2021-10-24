T=int(input())
for tc in range(1,T+1):
    N=int(input())
    num=bin(int(input(),16))
    arr=[0 for _ in range(9)]
    check=0
    for i in range(2,len(num)):
        if num[i]=="1":
            check+=1
        elif num[i]=="0" and check>0:
            arr[check-1]+=1
            check=0
    if check>0:
        arr[check-1]+=1
    print(arr)
