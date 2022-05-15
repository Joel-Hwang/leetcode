const originData = [
    {
      createdAt: 1651631739969,
      customType: 'feedback_message',
      message: 'Correction: 2feedback\nAlternative: s-alternative\nExplanation: s-explnation',
      messageId: 1818426952,
      parentMessageId: 1818408186,
      parentMessageText: 'Hello?',
    },
    {
      createdAt: 1651630975699,
      customType: 'feedback_message',
      message: 'Correction: feedback',
      messageId: 1818411982,
      parentMessageId: 1818408186,
      parentMessageText: 'Hello?',
    },
    {
      createdAt: 1651631739970,
      customType: 'feedback_message',
      message: 'Alternative: You could use this instead of that',
      messageId: 1818426953,
      parentMessageId: 1818408186,
      parentMessageText: 'Hello?',
    },
    {
      createdAt: 1651631739970,
      customType: 'feedback_message',
      message: 'Alternative: feedback7',
      messageId: 1818426954,
      parentMessageId: 1818408189,
      parentMessageText: 'Hi, Ciaran. I like this lesson.',
    },
  ];
/*
첫자퀴 돌면서 퍄런트 아이디 택스트 추출 파드백매시지 빈객체 키는 타입이 될 예정
두바퀴 돌면서 패런트 밑에 피드백 매시지 메세지타입 및 메세지 객체 추가
세자퀴 돌면서 메세지 배열 및 내용 추가
마지막으로 객체를 배열로 변환
*/
let formattedData = {} //parent key : {}
for(let row of originData){
    formattedData[row.parentMessageId] = {
        parentId: row.parentMessageId,
        parentMessage: row.parentMessageText,
        feedbackMessages: {}
    }
}

for(let row of originData){
    let pId = row.parentMessageId;
    let msgs = row.message.split('\n');
    for(msg of msgs){
        let msgAndType = msg.split(':');
        formattedData[pId].feedbackMessages[msgAndType[0]] = {
            messageType : msgAndType[0],
            messages : []
        };
    }
}

for(let row of originData){
    let pId = row.parentMessageId;
    let msgs = row.message.split('\n');
    for(msg of msgs){
        let msgAndType = msg.split(':');
        formattedData[pId].feedbackMessages[msgAndType[0]].messages.push(
            {
                id:row.messageId,
                message:msgAndType[1]
            }
        );
    }
}

console.log(formattedData);
for(let keyI in formattedData){
    formattedData[keyI].feedbackMessages = objToArray(formattedData[keyI].feedbackMessages); 
}

formattedData = objToArray(formattedData);
console.log(formattedData);

function objToArray(obj){
    let res = [];
    for(let key in obj)
    res.push(obj[key])
    return res;
}

const mockData = [
    {
      parentId: 1818408186,
      parentMessage: 'Hello?',
      feedbackMessages: [
        {
          messageType: 'Correction',
          messages: [
            {
              id: 1818426952,
              message: '2feedback',
            },
            {
              id: 1818411982,
              message: 'feedback',
            },
          ],
        },
        {
          messageType: 'Alternative',
          messages: [
            {
              id: 1818426953,
              message: 'You could use this instead of that',
            },
            {
              id: 1818426952,
              message: 's-alternative',
            },
          ],
        },
        {
          messageType: 'Explanation',
          messages: [
            {
              id: 1818426952,
              message: 's-explnation',
            },
          ],
        },
      ],
    },
    {
      parentId: 1818408189,
      parentMessage: 'Hi, Ciaran. I like this lesson.',
      feedbackMessages: [
        {
          messageType: 'Alternative',
          messages: [
            {
              id: 1818426954,
              message: 'feedback7',
            },
          ],
        },
      ],
    },
  ];