import os
import discord
from discord.ext import commands, tasks
from keep_alive import keep_alive
import time
from discord.ext import commands
from discord.ext.commands import Bot
import asyncio
from discord.ext.commands import has_permissions
client = commands.Bot(command_prefix= ",")
my_secret = os.environ['Token']

client.sniped_messages = {}

#member count
@client.command()
async def members(ctx):
  embedVar = discord.Embed(title=f'There Are {ctx.guild.member_count} Members In This Server', color=0xFF0000)
  await ctx.send(embed=embedVar)

#whois 
@client.command(aliases=["whois"])
async def userinfo(ctx, member: discord.Member = None):
    if not member:  # if member is no mentioned
        member = ctx.message.author  # set member as the author
    roles = [role for role in member.roles]
    embed = discord.Embed(colour=discord.Colour.purple(), timestamp=ctx.message.created_at,
                          title=f"User Info - {member}")
    embed.set_thumbnail(url=member.avatar_url)
    embed.set_footer(text=f"Requested by {ctx.author}")

    embed.add_field(name="ID:", value=member.id)
    embed.add_field(name="Display Name:", value=member.display_name)

    embed.add_field(name="Created Account On:", value=member.created_at.strftime("%a, %#d %B %Y, %I:%M %p UTC"))
    embed.add_field(name="Joined Server On:", value=member.joined_at.strftime("%a, %#d %B %Y, %I:%M %p UTC"))

    embed.add_field(name="Roles:", value="".join([role.mention for role in roles]))
    embed.add_field(name="Highest Role:", value=member.top_role.mention)
    print(member.top_role.mention)
    await ctx.send(embed=embed)

#bot ping
@client.command(description="Displays the Bot's latency")
async def ping(ctx):
  await ctx.send(f'{round(client.latency * 1000)}ms')

#kick,ban
@client.event
async def on_ready():
  print('{0.user} is online'.format(client))

  await client.change_presence(status=discord.Status.online, activity=discord.Activity(type=discord.ActivityType.listening, name=','))

@client.command()
@commands.has_permissions(kick_members=True)
async def kick(ctx,member:discord.Member=None,*,reason=None):
  await ctx.channel.purge(limit=1)
  if not member:
    await ctx.send("Please Mention Somebody To Kick")

  await member.kick(reason=reason)
  await ctx.send(embed=discord.Embed(title=f"{member.name} got kicked by {ctx.author.name}", description=f"Reason: **{reason}**"))
@kick.error
async def kick_error(ctx, error):
  if isinstance(error, commands.CheckFailure):
    await ctx.send("You Need The `kick members` Permissions To Do That Command")

@client.command()
@commands.has_permissions(ban_members=True)
async def ban(ctx,member:discord.Member=None,*,reason=None):
  await ctx.channel.purge(limit=1)
  if not member:
    await ctx.send("Please Mention Somebody To Ban")

  await member.ban(reason=reason)
  await ctx.send(embed=discord.Embed(title=f"{member.name} got banned by {ctx.author.name}", description=f"Reason: **{reason}**"))
@ban.error
async def ban_error(ctx, error):
  if isinstance(error, commands.CheckFailure):
    await ctx.send("You Need The `ban members` Permissions To Do That Command")

#purge
@client.command()
@commands.has_permissions(administrator=True)
async def purge(ctx, limit: int):
        await ctx.channel.purge(limit=limit)
        await ctx.message.delete()

@purge.error
async def purge_error(ctx, error):
    if isinstance(error, commands.MissingPermissions):
        await ctx.send("You cant do that!")
        
#snipe
@client.event
async def on_message_delete(message):
    client.sniped_messages[message.guild.id] = (message.content, message.author, message.channel.name, message.created_at)

@client.command(aliases=["snipe"])
async def s(ctx):
    try:
        contents, author, channel_name, time = client.sniped_messages[ctx.guild.id]

    except:
        await ctx.channel.send("Couldn't find a message to snipe!")
        return

    embed = discord.Embed(description=contents, color=discord.Color.purple(), timestamp=time)
    embed.set_author(name=f"{author.name}#{author.discriminator}", icon_url=author.avatar_url)
    embed.set_footer(text=f"Deleted in : #{channel_name}")

    await ctx.channel.send(embed=embed)

async def avatar(ctx, *, member: discord.Member = None):
    if not member:
        member = ctx.message.author
    em = discord.Embed(title=str(member), color=0xAE0808)
    em.set_image(url=member.avatar_url)
    await ctx.send(embed=em)

@client.command(pass_conetxt=True)
@commands.has_permissions(kick_members=True)
async def announce(ctx,*,message):
  embed=discord.Embed(title=f"Announcement",description=message,color=0x9208ea)
  embed.set_footer(text="made by 7#9414")
  await ctx.send(embed=embed) 

@client.command(pass_context=True)
async def hey(ctx):
  await ctx.send("sup faggot :partying_face:")

@client.command(pass_context=True)
async def whosdaddy(ctx):
  await ctx.send("lupo is daddy :wink:")

@client.command(pass_context=True)
async def whownsu(ctx):
  await ctx.send("lupo")

#bot life support
keep_alive()

client.run(my_secret)