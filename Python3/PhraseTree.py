class Token:
    def __init__(self, pos, word):
        '''
        Construct a token
        Args:
            pos: The part of speech, as a string.  i.e. NN, JJ, etc.
            word: The token's text, as a string
        '''
        self.pos = pos
        self.word = word

    def __str__(self):
        return f'({self.pos} {self.word})'
        

class Phrase:
    def __init__(self, phrase_type, children):
        '''
        Construct a phrase
        Args:
            phrase_type: The phrases type, as a string.  i.e. NP, VP, ADJP, etc.
            children: The phrase's children --- a list.  Each child is
                either a token (a leaf node) or another Phrase (an interior node)
        '''
        self.phrase_type = phrase_type
        self.children = children

    def __str__(self):
        leaves = ''
        for stuff in self.children:
            leaves = leaves + str(stuff)
        return f'({self.phrase_type} {leaves})'

# accept a list as input, l
# return the root node of a constituency tree made of Phrase and Token objects
def list2parsetree(l):
    checked = ''
    for item in l[1:]:
        if type(item[1]) != list:
            token = Token(item[0], item[1])
            checked += str(token)

        else:
            phrase = list2parsetree(item)
            if str(item[1]) in checked:
                checked -= item[1]
            checked += str(phrase)
            
    final = Phrase(l[0], [checked])
    return final

def list2parsetree2(l):
    children = []
    for item in l[1:]:
        if type(item) != list:
            token = Token(l[0], item)
            return token
        else:
            phrase = list2parsetree2(item)
            children.append(phrase)
        
    final = Phrase(l[0], children)
    return final

sentence = [
'S',
    ['NP',
        ['DT', 
            'The'],
        ['NN', 
            'cat']
    ],
    ['VP',
        ['VB', 
            'chases'],
        ['NP',
            ['DT', 
                'the'],
            ['NN', 
                'mouse']
        ]
    ],
    ['PUNCT', 
        '.']
]


print(list2parsetree(sentence))
print(list2parsetree2(sentence))