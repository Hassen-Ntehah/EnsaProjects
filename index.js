document.addEventListener('DOMContentLoaded', () => {
    const confirmBtn = document.getElementById('confirm-btn');
    const resetBtn = document.getElementById('reset-btn');
    const quizForm = document.getElementById('quiz-form');
    
   
    const correctReponse = {
        q1: '710,850 km²',
        q2: 'moktar ould daddah',
        q3: '54',
        q4: 'false', 
        q5: 'false'  
    };
  
    const feedbackElements = {
        q1: document.getElementById('q1-feedback'),
        q2: document.getElementById('q2-feedback'),
        q3: document.getElementById('q3-feedback'),
        q4: document.getElementById('q4-feedback'),
        q5: document.getElementById('q5-feedback')
    };
    
    const totalScoreEl = document.getElementById('total-score');

    confirmBtn.addEventListener('click', () => {
        let score = 0;
        let allRadioAnswered = true;

      
        clearFeedback();

        for (const [question, correctAnswer] of Object.entries(correctReponse)) {
            const feedbackEl = feedbackElements[question];
            let selectedValue;

            if (question === 'q4' || question === 'q5') {
               
                const checkbox = document.getElementById(question);
                
                selectedValue = checkbox.checked ? 'true' : 'false';
            } else {
              
                const selectedOption = document.querySelector(`input[name="${question}"]:checked`);
                if (selectedOption) {
                    selectedValue = selectedOption.value;
                } else {
                    selectedValue = null;
                }
            }
            
            if (selectedValue === null) {
                
                feedbackEl.textContent = 'Veuillez sélectionner une réponse.';
                feedbackEl.className = 'feedback-message feedback-missing';
                allRadioAnswered = false;
            } else if (selectedValue === correctAnswer) {
              
                feedbackEl.textContent = 'Correct !';
                feedbackEl.className = 'feedback-message feedback-correct';
                score++;
            } else {
                
                let correctAnswerText;
                if (question === 'q4' || question === 'q5') {
                 
                    correctAnswerText = (correctAnswer === 'true') ? 'Vrai' : 'Faux';
                } else {
                   
                    const correctLabel = document.querySelector(`input[name="${question}"][value="${correctAnswer}"]`);
                    correctAnswerText = correctLabel ? correctLabel.nextElementSibling.textContent : correctAnswer;
                }
                
                feedbackEl.textContent = `Incorrect. La bonne réponse est : ${correctAnswerText}`;
                feedbackEl.className = 'feedback-message feedback-incorrect';
            }
        }
        
       
        if (allRadioAnswered) {
            totalScoreEl.textContent = `Votre score est de ${score} sur 5 !`;
        } else {
            totalScoreEl.textContent = 'Veuillez répondre à toutes les questions à choix multiples pour voir votre score.';
        }
    });

    resetBtn.addEventListener('click', () => {
        clearFeedback();
        totalScoreEl.textContent = '';
    
        quizForm.reset();
    });
    
 
    function clearFeedback() {
        for (const key in feedbackElements) {
            const feedbackEl = feedbackElements[key];
            feedbackEl.textContent = '';
            feedbackEl.className = 'feedback-message';
        }
    }
});