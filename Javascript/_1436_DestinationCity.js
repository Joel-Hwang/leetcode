var getDestinationCity = function(paths){
    let departedCities = new Set(); 
    let arrivalCities = new Set();
    for(let path of paths){
        departedCities.add(path[0]);
        arrivalCities.add(path[1]);
    } 

    for(let arrivalCity of arrivalCities){
        if(departedCities.has(arrivalCity)) continue;
        return arrivalCity;
    }

    return null;
};

console.log(getDestinationCity([['A','B'],['B','C'],['C','D'],['D','E']]));