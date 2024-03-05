

$switOnly="swit_only_change.txt";
$uniOnly="unidata_only_change.txt";

@branches=($switOnly,$uniOnly);

foreach $branch(@branches){

  print "Merging: $branch\n";

  open IN, "$branch" or die "Cannot open $switOnly\n";
  @files=<IN>;

  $i=0;
  if($branch=~/swit/) { $cmd = "git checkout --theirs \"$file\""; }
  elsif($branch=~/unidata/) { $cmd = "git checkout --ours \"$file\""; }
  else { die "$branch did not match anything it was expecting\n"; }

  foreach $file(@files)
  {
    chomp $file;
    print "$file\n";
    `$cmd`;
    $cmd = "git add \"$file\"";
    `$cmd`;
    $i++;
  }
}
