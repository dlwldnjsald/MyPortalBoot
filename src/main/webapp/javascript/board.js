window.addEventListener('load', function() {
    document.querySelectorAll('.del-button').forEach(elem => {
        elem.addEventListener('click', function(event) {
            event.preventDefault();
            var confirmation = confirm('정말 삭제하시겠습니까?');
            if (confirmation) {
                window.location.href = this.getAttribute('href');
            }
        });

    })
});
