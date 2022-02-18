import spacy

nlp = spacy.load('en_core_web_md')
text="""Success isn't easy, and that's a good thing - at least in business. \
If it was easy, everybody would be doing it and your competition would be outrageous!"""
doc=nlp(text)

tokenized=[token.text for token in doc]
print(tokenized)

spacy_stopwords=spacy.lang.en.stop_words.STOP_WORDS
 
print(spacy_stopwords)
print("="*60)
 
#print("Total number of stopwords in spacy are {}".format(len(spacy_stopwords)))