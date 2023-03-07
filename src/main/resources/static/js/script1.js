const cards = document.querySelectorAll('.myCard');
let selectedCards = [];
let selecCardCount = 1;

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


  });
});
