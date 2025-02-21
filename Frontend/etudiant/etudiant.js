document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8081/etudiants')
        .then(response => response.json())
        .then(data => {
            const etudiantsList = document.getElementById('etudiants-list');
            data.forEach(etudiant => {
                const etudiantItem = document.createElement('div');
                etudiantItem.className = 'etudiant-item';
                etudiantItem.textContent = `Nom: ${etudiant.nom}, Âge: ${etudiant.age}`;
                etudiantsList.appendChild(etudiantItem);
            });
        })
        .catch(error => console.error('Erreur lors de la récupération des étudiants:', error));
});