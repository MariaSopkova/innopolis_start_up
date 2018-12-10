function removePet(petId) {
    $.ajax({
        url: '/pet/remove/' + petId,
        method: 'DELETE'
    }).done(function (data) {

    });
    location.reload();
}

function removePost(postId) {
    $.ajax({
        url: '/post/remove/' + postId,
        method: 'DELETE'
    }).done(function (data) {

    });
    location.reload();
}