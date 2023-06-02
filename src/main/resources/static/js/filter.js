function filterGames() {
    var checkedGenres = [];
    if (document.getElementById('actionCheckbox').checked) {
      checkedGenres.push('action');
    }
    if (document.getElementById('fightingCheckbox').checked) {
      checkedGenres.push('fighting');
    }
    if (document.getElementById('rpgCheckbox').checked) {
      checkedGenres.push('rpg');
    }
  
    var games = document.getElementsByClassName('game');
  
    for (var i = 0; i < games.length; i++) {
      var game = games[i];
      var genre = game.getAttribute('data-genre');
  
      if (checkedGenres.length === 0 || checkedGenres.includes(genre)) {
        game.classList.remove('hidden');
      } else {
        game.classList.add('hidden');
      }
    }
  }
  

window.onload = function() {
    filterGames();
};
    