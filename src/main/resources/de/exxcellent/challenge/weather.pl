#--------------------------------------------------
# Author: Caroline Raether
# Task: Weather Challenge
#--------------------------------------------------

use strict;

# programming-challenge/src/main/resources/de/exxcellent/challenge
my $input_filename="weather.csv";

open my $input_fh, "<", $input_filename
    or die "Could not open '$input_filename' - $!";

#Variables
my $min = 10000;
my $min_day = 0;

#Loop through file
while ( my $row = <$input_fh> ) {
   next if (1 .. 1); #Skip the first line (Header)
   chomp $row; #Read a line
   my ($day, $MxT, $MnT) = split(/,/, $row); #Read entries of a line
   # MxT and MnT are positive numbers
   if ($MxT - $MnT < $min) { #difference in temperature
      $min = $MxT - $MnT; 
      $min_day = $day;
   }

}

print "Day $min_day has the smallest temperature spread of $min.\n";

close($input_fh);
