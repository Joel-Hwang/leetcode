const regexp = /<(.*?)>/g;
var str = "this is <test@asdasd.ass> test, <te11st@asdasd.ass>, <te23st@asdasd.ass>";

const array = [...str.matchAll(regexp)];
array.forEach((elem)=>{
    console.log(elem[1])
});
   