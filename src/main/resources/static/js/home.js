function resetFilters() {
    if (document.getElementById('nameFilter')) {
        document.getElementById('nameFilter').value = ''
    }
    if (document.getElementById('categoryFilter')) {
        document.getElementById('categoryFilter').value = 0;
    }
    document.forms[0].submit();
}
document.addEventListener("DOMContentLoaded", () => {
    const toggleFilters = document.getElementById("toggleFilters");
    const filtersPopup = document.getElementById("filtersPopup");
    const closeFilters = document.getElementById("closeFilters");
    let name = "";
    let category = 0;

    toggleFilters.addEventListener("click", () => {
        name = document.getElementById('nameFilter').value;
        category = document.getElementById('categoryFilter').value;
        filtersPopup.classList.remove("hidden");
    });

    closeFilters.addEventListener("click", () => {
        document.getElementById('nameFilter').value = name;
        document.getElementById('categoryFilter').value = category;
        filtersPopup.classList.add("hidden");
    });

    // Ferme la popup si l'utilisateur clique en dehors
    filtersPopup.addEventListener("click", (e) => {
        if (e.target === filtersPopup) {
            filtersPopup.classList.add("hidden");
        }
    });
});
