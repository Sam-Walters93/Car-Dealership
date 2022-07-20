$("#home").click(function() {
    return "templates.home/index.html";
});

$("#new").click(function() {
    return "templates.inventory/new.html";
});

$("#used").click(function() {
     return "templates.inventory/used.html";
});

$("#specials").click(function() {
     return "templates.home/specials.html";
});

$("#contact").click(function() {
     return "templates.home/contact.html";
});

$(".jumbotron").click(function() {
     return "templates.home/contact.html";
});

$("document").ready(function(){
    $.ajax({
       method: "GET",
       url: "/vehicleInfo",
       success: function(data) {
           data = jQuery.parseJSON(data);
           
           data.forEach(x => {
               
               $("car-container").apppend(`

                <div class="card" style="width: 18rem;">
                 <img class="card-img-top" src="..." alt="Card image cap">
                <div class="card-body">
                <h5 class="card-title">${x.year} ${x.make} ${x.model}</h5>
                <p class="card-text">Color: ${x.color}</p>
                <p class="card-text">Transmission: ${x.transmission}</p>
                <p class="card-text">BodyStyle: ${x.bodystyle}</p>
                <p class="card-text">Mileage: ${x.mileage}</p>
                <p class="card-text">Price: $${x.salePrice}</p>
                <a href="#" class="carBtn btn-primary" id="${x.id}">Buy Me</a>
                </div>
                </div>`);  
           });
       }
    });
});