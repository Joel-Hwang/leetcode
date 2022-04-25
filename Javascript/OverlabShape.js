
function getDistance(s1, s2) {
	var bnd1 = s1.geometricBounds;
	var bnd2 = s2.geometricBounds;
	if(bnd1[0] > bnd2[0]){
		var temp = bnd1;
		bnd1 = bnd2;
		bnd2 = temp;
	}
	
	var isHoriz = bnd1[0] <= bnd2[0] && bnd2[0] <= bnd1[2];
	var horizDist = isHoriz?0:bnd2[0] - bnd1[2];    
	
	if(bnd1[3] > bnd2[3]){
		var temp = bnd1;
		bnd1 = bnd2;
		bnd2 = temp;
	}
	var isVert = bnd1[3] <=  bnd2[3] && bnd2[3] <= bnd1[1];
	var vertDist = isVert?0:bnd2[3] - bnd1[1];
	return horizDist + vertDist;
};

arr.sort(function(a, b)  {
    if(a[0] === b[0]) return a[3] - b[3];
    return a[0] - b[0];
});

console.log(getDistance({geometricBounds:[787.80  ,  -446.17  ,  1118.83  ,  -713.66]},{geometricBounds:[180.52  ,  -128.50  ,  572.89  ,  -424.39]}));
console.log(getDistance({geometricBounds:[1032.25  ,  -487.50  ,  1076.89  ,  -533.40]},{geometricBounds:[965.14  ,  -473.24  ,  1093.99  ,  -665.80]}));



/*
	var orderedShapes = [];
	for(var i = 0; i<groupItems.length; i++){
		orderedShapes.push(groupItems[i]);
	}
	orderedShapes.sort(function(s1, s2)  {
		var a = s1.geometricBounds;
		var b = s2.geometricBounds;
		if(a[0] === b[0]) return a[3] - b[3];
		return a[0] - b[0];
	});
	
	for(var i = 0; i<orderedShapes.length-1; i++){
		var dist = getDistance(orderedShapes[i], orderedShapes[i+1]);
		alert(dist);
	}*/

/*
function getDistance(s1, s2) {
	var bnd1 = s1.geometricBounds;
	var bnd2 = s2.geometricBounds;
	if(bnd1[0] > bnd2[0]){
		var temp = bnd1;
		bnd1 = bnd2;
		bnd2 = temp;
	}
	
	var isHoriz = bnd1[0] <= bnd2[0] && bnd2[0] <= bnd1[2];
	var horizDist = isHoriz?0:bnd2[0] - bnd1[2];    
	
	if(bnd1[3] > bnd2[3]){
		var temp = bnd1;
		bnd1 = bnd2;
		bnd2 = temp;
	}
	var isVert = bnd1[3] <=  bnd2[3] && bnd2[3] <= bnd1[1];
	var vertDist = isVert?0:bnd2[3] - bnd1[1];
	return horizDist + vertDist;
}*/