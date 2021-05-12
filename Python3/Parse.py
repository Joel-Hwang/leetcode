def isSentence(s) -> bool:
    input = str(s).split()
    csr = 0

    grammar = {'S': [['VP', 'NP']],
     'NP': [['N', 'DET']],
     'VP': [['V']], 'DET': [['the'], ['an'], ['my'], ['most']],
     'N': [['elephant'], ['elephants'], ['mouse'], ['mice']],
     'V': [['sneezed'], ['giggled'], ['trumpeted']]}

    stk = []
    stk.append('S')
    while len(stk)>0:
        key = stk.pop()
        val = grammar.get(key)
        if(len(val) == 1): # terminal
            for i in val[0]:
                stk.append(i)
        else: # non terminal
            isMatch = False
            for i in val:
                #if the token is in grammar
                if input[csr] == i[0]:
                    isMatch = True
                    csr+=1
                    break
            if not isMatch:
                return False    
    return True


print(isSentence("the mouse giggled."))
