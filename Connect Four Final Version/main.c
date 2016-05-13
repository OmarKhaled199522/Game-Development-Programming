#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <windows.h>
#include <string.h>

int x_index , y_index;
int arr1 [800];
int total [2] = {0};
int prev_total1 [800] ; int prev_total2 [800] ;
int count_for_total1;
int count_for_total2;
int comp = 0;

void reading_parameters (int *height , int *width , int *hiscores_no)
{
    int flag = 0 , found = 0 ;
    *width = -1 , *height = -1 , *hiscores_no = -1 ;
    char test , tempstr1[50] , tempstr2[] = "<Configurations>" , tempstr3[] = "</Configurations>" ;
    FILE *config = fopen("config.xml", "r") ;
    fscanf(config, "%s" , tempstr1) ;
    while ((strcmp(tempstr1 , tempstr2) != 0) && (fscanf(config, "%c", &test) != EOF))  // Scanning Opening Tag <Configurations>
    {
        fscanf(config, "%s" , tempstr1) ;
    }
    if (strcmp(tempstr1 , tempstr2) == 0)  // If Opening Tag Is Found
    {
        fscanf(config, "%s" , tempstr1) ;
        while ((strcmp(tempstr1 , tempstr3) != 0) && (fscanf(config, "%c", &test) != EOF)) // Scanning The Closing Tag </Configurations>
        {
            fscanf(config, "%s" , tempstr1) ;
        }
        if (strcmp(tempstr1 , tempstr3) != 0) // If Closing Tag is not Found
        {
            flag = 1 ;
        }
    }
    else // if opening tag is not found
    {
        flag = 1 ;
    }
    fclose(config) ;
    FILE *config1 = fopen("config.xml", "r") ; // scanning the width
    fscanf(config, "%s" , tempstr1) ;
    while ((strcmp(tempstr1 , tempstr2) != 0) && (fscanf(config, "%c", &test) != EOF))
    {
        fscanf(config, "%s" , tempstr1) ;
    }
    if (strcmp(tempstr1 , tempstr2) == 0) // scanning the width after finding the opening tag
    {
        while(fscanf(config1, "%c", &test) != EOF)
        {
            fscanf(config1, "<Width> %d </Width>", width) ;
            if (*width != -1) // after scanning the width , detect the closing tag
            {
                while(fscanf(config1, "%c", &test) != EOF)
                {
                    fscanf(config, "%s" , tempstr1) ;
                    if (strcmp(tempstr1 , tempstr3) == 0)
                    {
                        found = 1 ;
                    }
                }
            }
        }
        if (found == 0)
        {
            flag = 1 ;
        }
    }
    fclose(config1) ;
    found = 0 ;
    FILE *config2 = fopen("config.xml", "r") ; // scanning the height
    fscanf(config, "%s" , tempstr1) ;
    while ((strcmp(tempstr1 , tempstr2) != 0) && (fscanf(config, "%c", &test) != EOF))
    {
        fscanf(config, "%s" , tempstr1) ;
    }
    if (strcmp(tempstr1 , tempstr2) == 0) // scanning the height after finding the opening tag
    {
        while(fscanf(config2, "%c", &test) != EOF)
        {
            fscanf(config2, "<Height> %d </Height>", height) ;
            if (*height != -1) // after scanning the height , detect the closing tag
            {
                while(fscanf(config2, "%c", &test) != EOF)
                {
                    fscanf(config, "%s" , tempstr1) ;
                    if (strcmp(tempstr1 , tempstr3) == 0)
                    {
                        found = 1 ;
                    }
                }
            }
        }
        if (found == 0)
        {
            flag = 1 ;
        }
    }
    fclose(config2) ;
    found = 0 ;
    FILE *config3 = fopen("config.xml", "r") ;
    fscanf(config, "%s" , tempstr1) ;
    while ((strcmp(tempstr1 , tempstr2) != 0) && (fscanf(config, "%c", &test) != EOF))
    {
        fscanf(config, "%s" , tempstr1) ;
    }
    if (strcmp(tempstr1 , tempstr2) == 0)
    {
        while(fscanf(config3, "%c", &test) != EOF)
        {
            fscanf(config3, "<Highscores> %d </Highscores>", hiscores_no) ;
            if (*hiscores_no != -1)
            {
                while(fscanf(config3, "%c", &test) != EOF)
                {
                    fscanf(config, "%s" , tempstr1) ;
                    if (strcmp(tempstr1 , tempstr3) == 0)
                    {
                        found = 1 ;
                    }
                }
            }
        }
        if (found == 0)
        {
            flag = 1 ;
        }
    }
    fclose(config3) ;
    if ((flag == 1) || (*width == -1) || (*height == -1) || (*hiscores_no == -1)) // if any tag is incorrect
    {
        *width = 7 ; *height = 6 ; *hiscores_no = 5 ;
        printf("Incorrect Format of XML File : Default Loaded . \n") ;
        printf("Width = %d , Height = %d , High scores = %d\n\n", *width, *height, *hiscores_no) ;
    }
    else
    {
        if ((*width < 4) || (*height < 4) || (*hiscores_no < 0)) // if values of parameters are not valid
        {
            *width = 7 ; *height = 6 ; *hiscores_no = 5 ;
            printf("Incorrect Values For The Parameters : Default Loaded . \n") ;
            printf("Width = %d , Height = %d , High scores = %d\n\n", *width, *height, *hiscores_no) ;
        }
        else
        {
            if (*hiscores_no > 20) // high scores number greater than maximum
            {
                printf("The Maximum Size Of High Scores Number is 20 . Maximum Size Loaded .\n") ;
                *hiscores_no = 20 ;
            }
            if (*width > 15) // width greater than maximum
            {
                printf("The Maximum Width is 15 . Maximum Size Loaded .\n") ;
                *width = 15 ;
            }
            if (*height > 15) // height greater than maximum
            {
                printf("The Maximum Height is 15 . Maximum Size Loaded .\n") ;
                *height = 15 ;
            }
            printf("Reading Parameters from XML File Succeed .\n") ;
            printf("Width = %d , Height = %d , High scores = %d\n\n", *width, *height, *hiscores_no) ;
        }
    }

}
void print_game(int height , int width , char board [height] [width])
{
    HANDLE h = GetStdHandle ( STD_OUTPUT_HANDLE );

    int i , j ;
    for (i=0 ; i<2*height+2 ; i++)
    {
        for (j=0 ; j<width ; j++)
        {
            if ( i == 0 ) // printing numbers from 1 to width
            {
                SetConsoleTextAttribute ( h, FOREGROUND_GREEN | FOREGROUND_INTENSITY | 11);
                if (j > 9) printf(" %d " , j+1);
                else printf("  %d " , j+1) ;
            }
            else if (i%2 == 1) // printing horizontal line between each row
            {
                printf(" ---");

            }
            else if (j == 0) // printing the first column
            {
                SetConsoleTextAttribute ( h, FOREGROUND_RED | FOREGROUND_INTENSITY );
                printf("| ");
                if(board[i][j] == 'X') SetConsoleTextAttribute ( h, FOREGROUND_GREEN | FOREGROUND_INTENSITY );
                else SetConsoleTextAttribute ( h, FOREGROUND_BLUE | FOREGROUND_INTENSITY );
                printf("%c ", board[i][j]) ;
                SetConsoleTextAttribute ( h, FOREGROUND_RED | FOREGROUND_INTENSITY );
                printf("|");
            }
            else // printing the rest columns
            {

                if(board[i][j] == 'X') SetConsoleTextAttribute ( h, FOREGROUND_GREEN | FOREGROUND_INTENSITY );
                else SetConsoleTextAttribute ( h, FOREGROUND_BLUE | FOREGROUND_INTENSITY );
                printf(" %c ", board[i][j]) ;
                SetConsoleTextAttribute ( h, FOREGROUND_RED | FOREGROUND_INTENSITY );
                printf("|");
            }
        }
        printf("\n") ;
    }
}

char player_symbol() // choose the player symbol
{
    static int i = 1;
    i++;
    return (i % 2 == 0) ? 'X' : 'O';
}
int adding_symbol(int height , int width , int noc , int columns[width] ,
                  char board[][width] , char choose , int *un , int *num_of_un , int *num_of_redo ,
                  int *num_of_turns, int *repeat)
{
    int i; int help_point;
    char check;

    if(noc == 117){    // u = 117 Ascii code (undo)

        if(count_for_total1 == 0) return 3;  // first turn (nothing to be undo)
        else { printf("Enter the number of undo movements:\n");
        while ( (scanf("%d%c", &help_point , &check) !=2 ) ||
                (check != '\n') || (help_point <= 0)  ) {

            printf("Error!!!! enter a valid number please :\n");
            if(check != '\n') while(getchar() != '\n');
            else check = 'e'; // reseting the check char to any value different from \n
        }

        if(*num_of_turns >= help_point ){  // the number should be equal or smaller than num of plays
        for(i = 0; i < help_point; i++){

        board[arr1[*un - 2]][arr1[*un - 1]] = ' ';  // remove X OR O   // un indicates the index of the plays in the array for undo and redo
        columns[arr1[*un - 1]]--;  // an extra valid box due to undo movement

        if(choose == 'O'){

            Beep(1000,50);  // a function for making sounds
            count_for_total1--; // number of player 1 's plays decreases by one due to undo
            if (count_for_total1 >= 3){

                total[0] = prev_total1[count_for_total1 - 1]; // if player 1's plays less than 4 , so we can ignore change in score

            }
        } else {

            Beep(300,50);
            count_for_total2--;
            if(count_for_total2 >= 3) total[1] = prev_total2[count_for_total2 - 1]; // after undo we return to the past score
        }

        *num_of_un += 1;  //  when this value= 1 we can make redo  // why ++ doesn't work when this is pointer
        *un-=2;
        choose = player_symbol(); // changing the symbol so next undo will be for the other player

        }
        *repeat = help_point; // repeat : num of undo movements
        *num_of_turns -= help_point;
        return 1;

        } else {

            printf("You can't undo %d movement/s\n", help_point); // if num of undo more than num of plays
            adding_symbol( height ,  width ,  noc ,  columns ,  board ,  choose ,
                           un , num_of_un , num_of_redo ,num_of_turns,repeat);
            return 1; // 1 : indicates that undo movements have been made
        }
    }

    } else if (noc == 114){  // the player choose r (114) is the ASCII Code for r

        if(  (*num_of_un == *num_of_redo) ||  (*num_of_un == 0)  )  return 2;  // in these cases we can't redo plays

         else {printf("Enter the number of redo movements:\n");
         while ( (scanf("%d%c", &help_point , &check) !=2 ) ||
                 (check != '\n') || (help_point <= 0)  ) {

            printf("Error!!!! enter a valid number please :\n");
            if(check != '\n') while(getchar() != '\n');
            else check = 'e';   // just to reset the value of the char so as not to be \n
        }

        if(*num_of_un >= *num_of_redo + help_point){   // undo movements should be greater or equal to number of redo movements

        for(i = 0; i < help_point; i++){

            Beep(1500,50);

            if(choose == 'X' && count_for_total1 == count_for_total2){ // the reverse operation

                board[arr1[*un]][arr1[*un + 1]] = 'X';
                columns[arr1[*un + 1]]++;
                total[0] = prev_total1[count_for_total1];
                count_for_total1++;

            } else {

                if(choose == 'X') player_symbol();

                board[arr1[*un]][arr1[*un + 1]] = 'O';
                columns[arr1[*un + 1]]++;
                total[1] = prev_total2[count_for_total2];
                count_for_total2++;
            }

            *num_of_redo += 1;
            *un+=2;
            choose = player_symbol();
        }

            *repeat = help_point;
            *num_of_turns += help_point;
            return -1;

        } else if ( (*num_of_un == *num_of_redo) ||  (*num_of_un == 0)  ) {

            return 2; // indicates that no redo is available

        } else {

            printf("You can't redo %d movement/s\n", help_point);
            adding_symbol( height ,  width ,  noc ,  columns ,  board ,  choose ,
                           un , num_of_un , num_of_redo ,num_of_turns,repeat);
            return -1; // indicates that redo movements had been done
        }
    }

    } else {

        for (i=2*height ; i>=0 ; i-=2)
        {

            if (board[i][noc-1] == ' ')    // putting the play in the lowest available level
            {
                board[i][noc-1] = choose ;  // putting the play O OR X in the board
                if(choose == 'X') Beep(750,50);
                else Beep(300,50);
                columns[noc-1] += 1 ;
                x_index = i;
                y_index = noc - 1;
                arr1 [*un] = x_index;  // storing the index of the play for undo , redo
                arr1[*un + 1] = y_index;
                *un+=2;
                *num_of_turns += 1;
                *num_of_un = 0;  // reseting the number of undo & redo to zero
                *num_of_redo = 0;
                break ;
            }
        }
    }
    return 0;
}

void saving_game(int counter , int hiscores_no , int height , int width , int columns[width] , int total[2] , char board[3*height][width] , int un1 , int num_un , int num_redo , int num_turns1)
{
    int i , j ;
    FILE *saving_file ;
    saving_file = fopen("Saving.txt", "w");
    fprintf(saving_file , "%d %d\n" , height , width); // saving parameters of the game
    fprintf(saving_file, "%d\n" , hiscores_no) ;
    fprintf(saving_file, "%d\n", counter) ; // saving the number of turns played
    for (i=0 ; i<width ; i++)
    {
        fprintf(saving_file, "%d ", columns[i]) ; // saving the number of turns played in each column
    }
    fprintf(saving_file, "\n");

    fprintf(saving_file , "%d %d %d %d %d %d \n", un1 , num_un , num_redo , num_turns1 , count_for_total1 , count_for_total2);

    for(i = 0; i < num_turns1 * 2 + 1; i++){

        fprintf(saving_file , "%d %d %d ", prev_total1[i] , prev_total2[i] , arr1[i]);

    }

    fprintf(saving_file , "\n\n\n");

    for (i=2 ; i<2*height+2 ; i+=2) // saving the board of the game
    {
        for (j=0 ; j<width ; j++)
        {
            if (board[i][j] == ' ')
            {
                fprintf(saving_file, "0 ") ;
            }
            else if (board[i][j] == 'X')
            {
                fprintf(saving_file, "1 ");
            }
            else if (board[i][j] == 'O')
            {
                fprintf(saving_file, "2 ");
            }
        }
        fprintf(saving_file, "\n") ;
    }
    fprintf(saving_file, "%d %d %d" , total[0] , total[1], comp) ; // saving the scores
    fclose(saving_file) ;
}

int reading_the_column(int height , int width , int counter , int columns[width] , char board[3*height][width] , char choose)
{
   int ch = 0 ;char c ;
   int num [2] = {0}; int i = 0;
   int result = 0; int wrong = 0;

    if(comp == 1 && choose == 'X' &&  (count_for_total1 == count_for_total2) ){  // this code for the computer

        result = rand() % width + 1;  // result is the input from user or computer
        if ((columns[result-1] == height)) result =
            reading_the_column(height, width, counter, columns , board , choose); // in case computer choose a full column

    } else {

   printf("Player %d (%c) : Please Enter The Number of The Column :\n(s to Save Game)(u to Undo your Turn)(r to Redo your Turn)\n", (counter%2)+1 , choose);

    while((ch = getchar()) != '\n'){

        if(isdigit( (char)ch )){

            num[i] = ch - 48;
            i++;
            wrong = 2;
        }
         else if(isalpha((char) ch)){   // check if the input is undo / redo / save

            if( ( (char) ch != 'u' && (char) ch != 's' && (char) ch != 'r')|| ( wrong != 0 )){

                printf("Invalid input!!!!\n");
                break;

            } else  {

                wrong = 1;  // indicates that the input is character
                c = (char) ch;
             }
        } else {

            printf("Invalid input!!!!\n");
            break;
        }

        if(i > 2){ // maximum number consists of two digits

            printf("Invalid input!!!!!\n");
            wrong = 0; // indicates a wrong input
            break;
        }
   }
    if(wrong == 0) {

                    if (ch == 10) { // 10 is the ASCII of \n

                        printf("Invalid input\n"); // no more characters unwanted characters to absorb
                        result = reading_the_column(height, width, counter, columns , board , choose);

                    } else {

                        while(getchar() != '\n'); // to take unwanted characters
                        result = reading_the_column(height, width, counter, columns , board , choose);
                }
    }
   if (wrong == 1){

        return (int) c; // means that the user enter valid choice of alphabetics
   }

   if(wrong == 2){  // indicates that the user enter a number

        result = num[0];
        if(num[1] != 0) result *= 10 + num[1]; // if input more than 9
        if(result > width || result <=0 || i > 2){

            printf("Invalid Number : Please Enter a Number Between 1 and %d\n", width);
            result = reading_the_column(height, width, counter, columns , board , choose);
        } else if ((columns[result-1] == height)){ // a check if the column is full

            printf("The Column is Full !!! Please Choose Another Column\n") ;
            result = reading_the_column(height, width, counter, columns , board , choose);
        }
   }
   }
   return result;
}

void scores (int height , int width , char x [height] [width] , char symbol2 ,int x_index1 ,int y_index1)
{
    int i , j ,sum = 0 , sum1 = 0 , sum2 = 0, mince = 0 , who = 0;
    HANDLE h = GetStdHandle ( STD_OUTPUT_HANDLE );

    // calculate the horizontal score
    if(symbol2 == 'O') who = 1; // to determine which player turn

    for(i = y_index1 + 1; i < width; i++){ // calculate the number of similar chars in the right direction

        if(x[x_index1][i] == symbol2) sum1++; // num of similar plays
        else break; }

    for(j = y_index1 - 1; j >= 0; j--){

        if(x[x_index1][j] == symbol2) sum2++; // calculate in left direction
        else break;}

    if(sum1 >= 4) mince -= (sum1 - 3);  // to remove the old score (if the similar plays are 4 that means score = 1 , if plays = 5 : score = 2 )
    if(sum2 >= 4) mince -= (sum2 - 3);
    if(((sum1 >= 4) && (sum2 == 0)) || ((sum2 >= 4) && (sum1 == 0))) total[who]++;
    else {

        sum += 1 + sum1 + sum2 - 3 + mince; // -3 to calculate the score not the num of plays
        if(sum < 0) sum = 0;
        total [who] += sum;}
    // calculate the vertical score
    sum1 = 0; sum2 = 0; sum = 0;

    for(i = x_index1 + 2; i < 3 * height; i+=2){

        if(x[i][y_index1] == symbol2) sum1++;
        else break;}

    for(j = x_index1 - 2; j >= 0; j-=2){

        if(x[i][y_index1] == symbol2) sum2++;
        else break;}

    if(sum1 >= 4) mince -= (sum1 - 3);
    if(sum2 >= 4) mince -= (sum2 - 3);
    if(((sum1 >= 4) && (sum2 == 0)) || ((sum2 >= 4) && (sum1 == 0))) total[who]++;
    else {

        sum += 1 + sum1 + sum2 - 3 + mince;
        if(sum < 0) sum = 0;
        total [who] += sum;}
    // calculate the diagonal score
    sum1 = 0; sum2 = 0; sum = 0;

    j = y_index1 - 1;

    for(i = x_index1 + 2 ; i < 3 * height && j >= 0 ; i+=2){

        if(x[i][j] == symbol2) sum1++;
        else break;
        j--;}

    j = y_index1 + 1;

    for(i = x_index1 - 2; i >= 1 && j < width; i-=2 ){

        if(x[i][j] == symbol2) sum2++;
        else break;
        j++;}

    if(sum1 >= 4) mince -= (sum1 - 3);
    if(sum2 >= 4) mince -= (sum2 - 3);
    if(((sum1 >= 4) && (sum2 == 0)) || ((sum2 >= 4) && (sum1 == 0))) total[who]++;
    else {

        sum += 1 + sum1 + sum2 - 3 + mince;
        if(sum < 0) sum = 0;
        total [who] += sum;}

    sum1 = 0; sum2 = 0; sum = 0;

    for(i = x_index1 + 2 , j = y_index1 + 1;  i < 3 * height && j < width ; i+=2 , j++){

        if(x[i][j] == symbol2) sum1++;
        else break;}

    for(i = x_index1 - 2 , j = y_index1 - 1; i >= 1 && j < width; i-=2 , j--){

        if(x[i][j] == symbol2) sum2++;
        else break;}

    if(sum1 >= 4) mince -= (sum1 - 3);
    if(sum2 >= 4) mince -= (sum2 - 3);
    if(((sum1 >= 4) && (sum2 == 0)) || ((sum2 >= 4) && (sum1 == 0))) total[who]++;
    else {

        sum += 1 + sum1 + sum2 - 3 + mince;
        if(sum < 0) sum = 0;
        total [who] += sum;
        if(symbol2 == 'X'){  prev_total1[count_for_total1] = total[0]; count_for_total1++;
        } else {              prev_total2[count_for_total2] = total [1]; count_for_total2++;}
    }

    SetConsoleTextAttribute ( h, FOREGROUND_RED | FOREGROUND_INTENSITY | 9);
    if (comp != 1) printf("Player's 1 score :%d\nPlayer's 2 score :%d\n\n", total[0] , total [1]);
    else           printf("Computer score :%d\nPlayer's 2 score :%d\n\n", total[0] , total [1]);
}

void high_scores(int total[] , int hiscores_no , int hiscores[])
{
    int max = 0 , min = 0 , min_no = 0 , found = 0 , temp = 0 , i = 0 , j = 0 ;
    if (total[0] >= total[1]) // detect the Winner
    {
        max = total[0] ;
        if (comp != 1) printf("Congratulations : The Winner is Player 1 . \n");
        else           printf("Congratulations : The Winner is Computer . \n");
    }
    else
    {
        max = total[1] ;
        printf("Congratulations : The Winner is Player 2 . \n") ;
    }
    min = hiscores[0] ;
    for (i=0 ; i<20 ; i++) // adding the new high score to the list of high scores instead of the least high score if it's greater than it
    {
        if (max > hiscores[i])
        {
            for (j=0; j<20 ; j++)
            {
                if (hiscores[j] <= min)
                {
                    min_no = j ;
                    min = hiscores[j] ;
                    found = 1 ;
                }
            }
            break ;
        }
    }
    if (found == 1) // if a new high score is added to the list
    {
        hiscores[min_no] = max ;
        for (i=0 ; i<20 ; i++) // sorting the list
        {
            for (j=0 ; j<20 ; j++)
            {
                if (hiscores[i] > hiscores[j])
                {
                    temp = hiscores [i] ;
                    hiscores[i] = hiscores[j] ;
                    hiscores[j] = temp ;
                }
            }
        }
    }
    printf("The First %d High Scores are :\n", hiscores_no) ;  // printing the hiscores_no of high scores
    for (i=0 ; i<hiscores_no ; i++)
    {
        printf("%d)%d\n", i+1 , hiscores[i]);
    }
    printf("\n");
    FILE *hi_file2 = fopen("highscores.k", "w"); // saving the new high scores
    for (i=0 ; i<20 ; i++)
    {
        fprintf(hi_file2, "%d ", hiscores[i]);
    }
}

int main()
{

    Beep(1000,200);
    HANDLE h = GetStdHandle ( STD_OUTPUT_HANDLE );


    int hiscores_no = 5 , hiscores[20] = {0} ;
    int width = 7 , height = 6 , i , j , noc = 0 , counter = 0 ; char choose ;
    int check = 2 , option = 3;
    int un = 1, repeat = 0;
    int num_of_turns = 0;
    int num_of_un = 0;
    int num_of_redo = 0;
    char p_or_com [1] = "p"; char check_char;

    FILE *loaded_file = fopen("saving.txt", "r") ; // opening the loading file
    FILE *hi_file1 = fopen("highscores.k", "r") ; // opening the high scores file
    SetConsoleTextAttribute ( h, FOREGROUND_GREEN | FOREGROUND_INTENSITY | 3);
    printf("********************************************************************************\n");
    SetConsoleTextAttribute ( h, FOREGROUND_BLUE | FOREGROUND_INTENSITY | 4);
    printf("**** Welcome To Connect Four Game, Prepared By Mohamed Adel and Omar Khaled ****\n") ;
    printf("********************************************************************************\n\n") ;
    SetConsoleTextAttribute ( h, FOREGROUND_GREEN | FOREGROUND_INTENSITY | 3);


    while (option == 3)
    {
        printf("1)New Game\n2)Load Last Saved Game\n3)High Scores\n4)Exit\n\n") ;
        printf("Please : Enter The Number of Your Choice : ") ;
        while ( (scanf("%d%c", &option , &check_char) !=2 )  || (check_char != '\n') || option <=0 || option > 4 ){ // check for invalid input

            printf("Error!!! Enter a number between 1 : 4\n");
            Beep(3500 , 300);
            if(check_char != '\n') while(getchar() != '\n');
            else check_char = 'e';
        }

        if(option == 1){ // new game

            printf("Player vs Player  (or) Computer vs Player    (h / c)\n");
            scanf("%s", p_or_com);

            while ( ( strcmp(p_or_com , "h") != 0 )  &&  ( strcmp( p_or_com , "c" ) != 0 )){ // check for invalid inputs

                printf("Invalid input !!!!!!\n");
                Beep(3500 , 300);
                scanf("%s", p_or_com);
            }

            printf("\a");
            if(strcmp(p_or_com , "c") == 0) comp = 1;
            reading_parameters (&height , &width , &hiscores_no) ;
            for (i=0 ; i<20 ; i++)
            {
                fscanf(hi_file1, "%d ", &hiscores[i]) ;
            }

        } else if (option == 2) { // load last saved game

            fscanf(loaded_file , "%d %d\n", &height , &width); // loading parameters
            fscanf(loaded_file , "%d\n", &hiscores_no);
            for (i=0 ; i<10 ; i++) // loading high scores
            {
                fscanf(hi_file1, "%d ", &hiscores[i]) ;
            }

        } else if (option == 3){ // view high scores

            reading_parameters (&height , &width , &hiscores_no) ; // read parameters
            for (i=0 ; i<20 ; i++) // reading high scores from file
            {
                fscanf(hi_file1, "%d ", &hiscores[i]) ;
            }
            for (i=0 ; i<hiscores_no ; i++) // printing high scores
            {
                printf("%d)%d\n", i+1 , hiscores[i]) ;
            }
            printf("\n\n") ;
        }
        else if (option == 4) // exit
        {
            return 0 ;
        }
    }

    int Columns[100] = {0} ; // store the number of symbol in each column
    int loaded_array[3*height][width] ; // store the board loaded from the file int he form of integers
    char board[3*height][width] ; // store the symbols

    if ((option == 1) || (option == 2))
    {
        if (option == 1)
        {

            for (i=0; i<3*height ; i++) // initialization of the game board
            {
                for (j=0 ; j<width ; j++)
                {
                    board[i][j] = ' ' ;
                }
            }
        }
        else
        {

            fscanf(loaded_file, "%d", &counter);  // loading the number of turns

            for (i=0 ; i<width ; i++) // loading the number of symbols in each column
            {
                fscanf(loaded_file, "%d", &Columns[i]);
            }

            fscanf(loaded_file , "%d %d %d %d %d %d\n", &un , &num_of_un , &num_of_redo , &num_of_turns , &count_for_total1 , &count_for_total2);

             for(i = 0; i < num_of_turns * 2 + 1; i++){

                 fscanf(loaded_file , "%d %d %d", &prev_total1[i] , &prev_total2[i] , &arr1[i]);

             }

            for (i=2 ; i<2*height+2 ; i+=2) // loading the board as integers and change it into characters
            {
                for (j=0 ; j<width ; j++)
                {
                    fscanf(loaded_file, "%d", &loaded_array[i][j]) ;
                    if (loaded_array[i][j] == 0)
                    {
                        board[i][j] = ' ' ;
                    }
                    else if (loaded_array[i][j] == 1)
                    {
                        board[i][j] = 'X' ;
                    }
                    else if (loaded_array[i][j] == 2)
                    {
                        board[i][j] = 'O' ;
                    }
                }
            }
            fscanf(loaded_file, "%d %d %d" , &total[0] , &total[1] , &comp); // loading scores
        }
        print_game(height , width , board) ;
        if (comp != 1 )     printf("Player's 1 score :%d\nPlayer's 2 score :%d\n\n", total[0] , total [1]);
        else                printf("Computer score :%d\nPlayer's 2 score :%d\n\n", total[0] , total [1]);

        if (option != 2)    getchar();

        while (counter < height*width) // loop keeps the game until the board is completed
        {
            choose = player_symbol();
            noc = reading_the_column(height , width , counter , Columns , board , choose) ;
            if (noc == 115) // if saving game
            {
                saving_game(counter , hiscores_no , height , width , Columns , total , board, un , num_of_un , num_of_redo , num_of_turns);
                choose = player_symbol() ; // that mean the same player will play after save so change the player now so as to return the same player after choose function in the start of program loop
                counter-- ; // to decrease the number of turns
            }
            if (count_for_total1 > count_for_total2 && choose == 'X') choose = player_symbol();

            check = adding_symbol(height , width , noc , Columns , board , choose, &un , & num_of_un , &num_of_redo , &num_of_turns, &repeat) ;
            if(check == 1 || check == -1) {counter -= check * repeat; // to decrease or increase the counter in case of undo / redo
                if(repeat % 2 == 0) choose = player_symbol(); // that mean the same player will play after undo or redo so change the player now so as to return the same player after choose function in the start of program loop
                else player_symbol();   // without changing choose // to adjust the static int in the choose function
                print_game(height , width , board) ;
                if (comp != 1) printf("Player's 1 score :%d\nPlayer's 2 score :%d\n\n", total[0] , total [1]);
                else           printf("Computer score :%d\nPlayer's 2 score :%d\n\n", total[0] , total [1]);
                check = 0;

            } else if  (check == 2){

                printf("You should undo your turn first!!!!!\n");
                player_symbol();

            } else if (check == 3){

                printf("you haven't entered anything to undo!!!!!\n");
                player_symbol();

            } else {counter++ ;
                print_game(height , width , board) ;
                scores(height , width , board , choose , x_index , y_index);
            }
        }
        if (counter == height * width) // when the game completes
        {
            high_scores(total , hiscores_no , hiscores) ;
        }
    }
    Beep(900,200);
    return 0;
}
