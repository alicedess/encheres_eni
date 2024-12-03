function resetFilters() {
    if (document.getElementById('nameFilter')) {
        document.getElementById('nameFilter').value = ''
    }
    if (document.getElementById('categoryFilter')) {
        document.getElementById('categoryFilter').value = 0;
    }
    document.forms[0].submit();
}
