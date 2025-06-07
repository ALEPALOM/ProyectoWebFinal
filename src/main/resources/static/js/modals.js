export function activarModales(){
    var modal = document.getElementById('modal1');
    var modalBody = modal.querySelector('.modal-body');
    
  modal.addEventListener('show.bs.modal',function(event){
    var button = event.relatedTarget;
    var servicio = button.getAttribute('data-servicio');
    switch(servicio){
      case 'marketing':
        modalBody.innerHTML=`
        <h5>Servivio de Marketing</h5>
        <p>Este servivio  dura 5 meses...</p>
        <a href="#" class="btn btn-primary"> Ver mas</a> 
        `;
        break
        case 'cubicol':
        modalBody.innerHTML=`
        <h5>Plataforma de servivio cubicol</h5>
        <p>Este servivio consta en la personalización de la plataforma y soporte técnico...</p>
        <a href="#" class="btn btn-primary"> Ver mas</a> 
        `;
    }
  });
};