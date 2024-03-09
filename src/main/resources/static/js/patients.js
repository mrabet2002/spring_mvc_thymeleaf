const openModal = patientId => {
    console.log(patientId)
    let confirmDeleteModal = document.getElementById('confirmDelete');
    if (confirmDeleteModal) {
        // Update the modal's content.
        const modalConfirmBtn = confirmDeleteModal.querySelector("#delete-btn")

        modalConfirmBtn.setAttribute('href', `patients/delete/${patientId}`)
        confirmDeleteModal =  new bootstrap.Modal(document.getElementById('confirmDelete'))
        confirmDeleteModal.show()
    }
}