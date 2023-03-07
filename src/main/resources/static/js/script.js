const cards = document.querySelectorAll('.card');
const playButton = document.querySelector('#play-button');
let selectedCards = [];
let selecCardCount = 3;

cards.forEach(card => {
  card.addEventListener('click', () => {

	if (selectedCards.includes(card)) {
      card.classList.remove('selected');
      selectedCards = selectedCards.filter(selectedCard => selectedCard !== card);
	  card.classList.remove('move-up');
    } else if (selectedCards.length < selecCardCount) {
      card.classList.add('selected');
	  const isMovedUp = card.classList.contains('move-up');
	  card.classList.add('move-up');
	  const id = card.id;
	  console.log(`Clicked card ID: ${id}`);
      selectedCards.push(card);
    }

	if (selectedCards.length === 3) {
      playButton.style.display = 'block';
    } else {
      playButton.style.display = 'none';
    }
  });
});

playButton.addEventListener("click", function() {
  window.location.href = "./arena.html"; 
});
