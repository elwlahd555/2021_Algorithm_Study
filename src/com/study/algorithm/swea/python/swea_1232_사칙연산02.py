def dfs(idx):
    if idx > N:
        return
    if type(tree[idx]) != str:
        a = dfs(2 * idx)
        b = dfs(2 * idx + 1)
 
    else:
        a = dfs(left[idx])
        b = dfs(right[idx])
 
    if tree[idx] == '+':
        tree[idx] = a + b
    elif tree[idx] == '-':
        tree[idx] = a - b
    elif tree[idx] == '*':
        tree[idx] = a * b
    elif tree[idx] == '/':
        tree[idx] = a / b
 
    return tree[idx]
 
 
T = 10
for tc in range(1, T+1):
    N = int(input())
    tree = [0]
    left = [-1 for t in range(N+1)]
    right = [-1 for t in range(N + 1)]
    for t in range(N):
        line = input().split()
        if len(line) > 2:
            tree.append(line[1])
            left[int(line[0])] = int(line[2])
            right[int(line[0])] = int(line[3])
        else:
            tree.append(int(line[1]))
 
    de = -1
    ret = dfs(1)
    print('#{} {}'.format(tc,int(ret)))



def dfs2(node):
    if type(adj[node]) == int:
        return adj[node]
    a = int(adj[node][1])
    b = int(adj[node][2])
    c1 = dfs2(a)
    c2 = dfs2(b)
    p = adj[node][0]
    if p == '-':
        ret = c1 - c2
    elif p == '+':
        ret = c1 + c2
    elif p == '*':
        ret = c1 * c2
    else:
        ret = c1 / c2
    return ret
 
T = 10
for tc in range(T):
    N = int(input())
    adj = [[] for _ in range(N+1)]
    for i in range(N):
        put = list((input().split()))
        if len(put) == 4:
            n, p, c1, c2 = put
            adj[int(n)] = [p, c1, c2]
        else:
            n, v = put
            adj[int(n)] = int(v)
 
    ans = int(dfs2(1))
    print('#{} {}'.format(tc+1, ans))